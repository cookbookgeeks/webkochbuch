webkochboch by cookbookgeeks
============================
contact info:
______________
email:		cookbookgeeks@gmx.de

### Webkochbuch hosted by heroku
http://webkochbuch.herokuapp.com/

### Run webkochbuch locally

> - webkochbuch currently works with its old database tables. There is a script called 
>  webkochbuch_createtables_experimental.sql to create the corresponding database tables.
> - IMPORTANT: Due to the fact that this Version is build to run on heroku and similar platforms, 
>  you have to edit line 19 in server.xml of your local spring IDE to make hyperlinks and includes work!   
> - The user of your database which is used by webkochbuch must have the rights to read and write the corresponding tables.
>  To achieve that, open a sql command line and type;
>  GRANT SELECT on recipes to username;
>  GRANT CREATE on recipes to username;
>  GRANT DELETE on recipes to username;
>  GRANT UPDATE on recipes to username;
> - Follow the instructions of the experimental database script to create a sequence for automatic id incrementation!
> - webkochbuch reads its database url (including username and password) from an environment variable called DATABASE_URL.
>  You have to set this environment variable on your local setup to be able to connect to your database.
  
### Future plans

> - it is planned to port the java code to work with the new database tables
