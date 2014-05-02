webkochboch by cookbookgeeks
============================
contact info:
-------------
email:		cookbookgeeks@gmx.de

### Webkochbuch hosted by heroku
http://webkochbuch.herokuapp.com/

### Run webkochbuch locally

 - Install postgesql, start it and create a new database.
 - Call the sql script "webkochbuch_createtables_experimental.sql on the database (replace 'username' with your postgres username).
 - Due to the fact that this Version is build to run on heroku and similar platforms, 
  you have to edit line 19 in server.xml of your local spring IDE to make hyperlinks and includes work!
 - webkochbuch reads its database url (including username and password) from an environment variable called DATABASE_URL.
   You have to set this environment variable on your local setup to be able to connect to your database.
   It looks like that: postgres://username:password@hostname:port/database
 - Create a directory where webkochbuch can store uploaded files. You have to make sure that webkochbuch has the rights to write/read on that directory. Store the path to the directory in an environment variable called WEBKOCHBUCH_UPLOADS_DESTINATION
 - Create a directory where webkochbuch can store index files for its fulltext search. Remember that webkochbuch must have write permissions on it.
 - Store the path of the newly created directory in an enviroment variable calles 'LUCENE_INDEX_LOCATION'.
 - When you run will run webkoch for the first time after adding the index directory, enter the following URL: <host>/search/createindex This will create index files for all existing, unindexed database objects.
 - Now, run webkochbuch using the spring tool suite or call the corresponding maven commands.
  
### Future plans

 - it is planned to port the java code to work with the new database tables
