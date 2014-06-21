Installing webkochbuch
======================

This installation guide will show you how to install and run webkochbuch on Unix systems.

## Building webkochbuch from its sources

You will need to install a few programs to be able to build webkochbuch.

* Oracle JDK 7 or OpenJDK 7 for 64 bit systems (32 bit version won't work!).
* Maven
* Git

### Download the sources

```bash
$ git clone https://github.com/cookbookgeeks/webkochbuch.git
```

### Build a war file

First, go into the root directory of the sources.

```bash
$ cd webkochbuch
```

Now you have to compile the sources and build a war file. Tests will be skipped because that would
need further preperations (e.g. a running database, ...).

```bash
$ mvn package  -Dmaven.test.skip=true
```

You will find the final war file in `target/<filename>.war`.

## Set up a production environment

The following steps will teach you step by step to set up runtime dependencies for webkochbuch.

### Installation of runtime dependencies

Besides of the JVM already installed with the JDK before the build process, install the following
programs.

* Postgresql 9.3

### Create a database

Create an empty postgres database.

```bash
$ createdb webkochbuch_db
```

Assuming you still are in the root directory of the webkochbuch sources, run the sql script
on the created database.

```bash
$ psql -d webkochbuch_db -f create_tables.sql
```

Now put the corresponding database connection URL into an environment variable called `DATABASE_URL`.

```bash
$ export DATABASE_URL=postgres://wkb_app_user:Ahawolq7RuTTAGCyWML6@localhost:5432/webkochbuch_db
```

### Index and uploads storage

Lucene index files and upload files will need directories with rw rights on it.

```bash
$ mkdir /home/<your username>/webkochbuch_index_files
$ mkdir /home/<your username>/webkochbuch_upload_files
```

Put the paths into the following enviroment variables and you're ready to go!

```bash
$ export LUCENE_INDEX_LOCATION=/home/<your username>/webkochbuch_index_files
$ export WEBKOCHBUCH_UPLOADS_DESTINATION=/home/<your username>/webkochbuch_upload_files
```

### Edit server.xml of Apache Tomcat

Finally, you have to edit two lines of the `server.xml` file of Apache Tomcat, the Webserver webkochbuch will be deployed to.

At first, put the line

```xml
<Context docBase="/home/<your username>/webkochbuch_upload_files" path="/images" reloadable="true" />
```

## Deploy webkochbuch to Apache Tomcat

All you have to do now is to deploy the war file to your local tomcat instance.

TODO