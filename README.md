# Project Title

Student Management System using Netbean on JBoss

## Getting Started

Before running this project, you need some prerequisites and install something 

### Prerequisites

Install postgresql
Create new server WildFly using EAP-7.2.0 on Netbeans
Certainly, you have Netbeans

### Installing

Restore backup file

```
Open pgAdmin 4 and create new database. Chose File->References->Binary paths->Link to bin folder of postgresql.
Right click on database, choose restore and find backup file you need to load.
```
And you need to add user for JBoss server

```
Go to H:\EAP-7.2.0\jboss-eap-7.2\bin, choose Add-user.bat(H:\ is my drive, depends on your folder).
But before running this file, you need open Netbeans and start server WildFly. After that, open Admin Console, enter username and password.
```
## Deployment

You see 2 application in my file, first is StudentEJB and seccond is StudentManagementSystem. 
You need clean and build StudentEJB and deploy it onto WildFly Server.
Add file jar that has been built to StudentManagementSystem.
Connect to database at Services tab. Link to correct path to database.
Run it.

## Authors

* **Hau Nguyen Phuc**
