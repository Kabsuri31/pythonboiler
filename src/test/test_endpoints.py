from app import app
import os
import sqlite3
import unittest

class FlaskTodosTest(unittest.TestCase):

    def setUp(self):
        app.config['TESTING'] = True
        self.app = app.test_client()
        self.db_path = 'test_todo.db'

        # Create a test database and table
        if not os.path.exists(self.db_path):
            self.create_test_database()

    def tearDown(self):
        """Clear DB after running tests"""
        os.remove(self.db_path)

    def create_test_database(self):
        db = sqlite3.connect(self.db_path)
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

    def test_home_status_code(self):
        """Assert that user successfully lands on homepage"""
        result = self.app.get('/')
        self.assertEqual(result.status_code, 200)

    def test_todo_creation(self):
        """Assert that user is redirected after creating todo item"""
        response = self.app.post('/new',
                                 data=dict(name="First todo",
                                           description="Test todo")
                                 )
        self.assertEqual(response.status_code, 302)


if __name__ == '__main__':
    unittest.main()

