FROM alpine:3.13 AS base
ADD src/ /todo/
RUN apk --update add openssl ca-certificates musl \
    && apk --update add --virtual build-dependencies build-base wget \
    && apk --update add python3 py3-pip
RUN pip3 install --target="/todo/packages/" -r ./todo/requirements.txt

FROM python:3.8.13-alpine AS main
COPY --from=base /todo /todo
RUN cp -r /todo/packages/* /usr/local/bin/ \
    && addgroup -g 1000 appgroup \
    && adduser -u 1000 -G appgroup -h /home/appuser -D appuser \
    && chown -R appuser /todo
WORKDIR /todo
ENV PYTHONPATH="/usr/local/bin"
USER appuser
ENTRYPOINT ["python3", "app.py"]
