webkochboch by cookbookgeeks [![Build Status](https://travis-ci.org/cookbookgeeks/webkochbuch.png)](https://travis-ci.org/cookbookgeeks/webkochbuch)
============================
contact info:
-------------
email:		cookbookgeeks@gmx.de

## Hosting

An older version of webkochbuch ist hosted by heroku: http://webkochbuch.herokuapp.com/
However, we currently work on hosting webkochbuch by a private webserver due to limitations of Heroku.

## Run webkochbuch locally

The following guide will show you how to set up a development environment for webkochbuch.

### Database setup

At first, you will need to install postgresql. On Windows, load the corresponding installer (9.3). On Unix, simply install the package of your distribution of choice. On Debian this would be:

```bash
# apt-get install postgresql
```

Now, you have to start postgresql as a system service. On Unix, you have to call the init command of your distribution. If you use systemd as your init system, call:

```bash
# systemctl start postgresql
```

After that, create a database and the tables for webkochbuch:

```bash
$ createdb webkochbuch_db
$ psql webkochbuch_db
webkochbuch_db=> \i webkochbuch_createtables.sql
webkochbuch_db=> \q
```

Webkochbuch will get its database connection details from an environment variable called `DATABASE_URL`. You have to set it using the following schema (assuming a UNIX system):

```bash
$ export DATABASE_URL=postgres://username:password@hostname:port/database
```

Remember that this will only set your environment variable temporarily in your current shell. To make it globally visible and persistent after reboots, you have to put the preceding command into a file called `/etc/profile.d/webkochbuch.sh`.

### Uploads folder

Webkochbuch needs a folder with read and write permissions on it to store files dynamically (file uploads from users).

Create one and set an environment variable called `WEBKOCHBUCH_UPLOADS_DESTINATION` with the path of the uploads folder in it.

### Index-files folder

Webkochbuch uses Apache Lucene to create index files of its database entries. They will be used by Hibernate-Search. Create a directory with read and write permissions on it and store the path of it in an environment variable called `LUCENE_INDEX_LOCATION`.

### Edit server.xml of Apache Tomcat

Finally, you have to edit two lines of the `server.xml` file of Apache Tomcat, the Webserver webkochbuch will be deployed to.

At first, put the line

```xml
<Context docBase="/home/nils/wkb_uploads" path="/images" reloadable="true" />
```

into the host section of the xml file. Remember to replace the `docBase` attribute value with the path of your created upload files folder.

After that, replace the value of the attribute `path` from the other `Context` tag (its docBase value should contain "webkochbuch") with `/`. After these two steps, the host section of the xml file should look similar to that:

```xml
<Context docBase="webkochbuch" path="/" reloadable="true" source="org.eclipse.jst.jee.server:webkochbuch"/>
<Context docBase="/home/nils/wkb_uploads" path="/images" reloadable="true" />
```

### (If your database already contains entries)

This last section will only be important to you, if your database already contains entries. Then you have to call a GET Request (by typing the corresponding URL into your Webbrowser) on the URL `http://localhost:8080/search/createindex`. This will create index files for Hibernate-Search for your unindexed database entries (assuming the configured port of your Tomcat is 8080).

### Start webkochbuch!

Congratulations! Your development environment is ready. Import webkochbuch by cloning from github

```bash
$ git clone git@github.com:cookbookgeeks/webkochbuch.git
```

and import the sources as a maven project into the Spring Tool Suite.

## Documentation

We use GitHub pages to host our javadoc files: [Official Documentation](http://cookbookgeeks.github.io/webkochbuch/)
