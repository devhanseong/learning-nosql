FROM mongodb/mongodb-community-server

ENV MONGO_INITDB_ROOT_USERNAME=learning
ENV MONGO_INITDB_ROOT_PASSWORD=password

VOLUME /data/db

EXPOSE 27017