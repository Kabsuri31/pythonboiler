from flask import Flask, redirect, url_for, request, render_template, session
import sqlite3
import os

app = Flask(__name__)
app.secret_key = 'test'  
db_path = '/tmp/todo.db'

if not os.path.exists(db_path):
    db = sqlite3.connect(db_path)
    cursor = db.cursor()
    create_table_sql = """
        CREATE TABLE IF NOT EXISTS todos (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            description TEXT
        )
    """
    cursor.execute(create_table_sql)
    db.commit()
    cursor.close()
    db.close()

@app.route('/')
def todo():
    try:
        db = sqlite3.connect(db_path)
        cursor = db.cursor()
        cursor.execute("SELECT * FROM todos")
        items = cursor.fetchall()
        cursor.close()
        db.close()
    except sqlite3.Error as e:
        # Handle database error
        return f"Database Error: {e}"

    if items: 
        session['items'] = items
    else:  
        session.pop('items', None)

    return render_template('index.html', items=items, new_item=None)

@app.route('/new', methods=['GET', 'POST'])
def new():
    if 'items' in session:
        items = session['items']
    else:
        items = None

    if request.method == 'POST':
        name = request.form['name']
        description = request.form['description']

        try:
            db = sqlite3.connect(db_path)
            cursor = db.cursor()
            cursor.execute("INSERT INTO todos (name, description) VALUES (?, ?)", (name, description))
            db.commit()

            cursor.execute("SELECT * FROM todos WHERE id = LAST_INSERT_ROWID()")
            new_item = cursor.fetchone()

            cursor.close()
            db.close()
        except sqlite3.Error as e:
            return f"Database Error: {e}"

        return redirect(url_for('todo'))  


    return render_template('index.html', items=items, new_item=None)

if __name__ == "__main__":
    app.run(host='0.0.0.0',port=8080)

