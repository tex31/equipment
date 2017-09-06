JSF, Spring, JPA CRUD blog application
---

The web application using JSF 2, PrettyFaces, Spring and JPA.

#### Used frameworks
- Spring
- JPA/Hibernate
- Apache Tomcat 7 server
- [PrettyFaces](http://ocpsoft.org/prettyfaces/) for pretty URLs.
- [Zurb Foundation 5](http://foundation.zurb.com/)

#### Database

- The project uses the [H2 embedded database](http://www.h2database.com/html/main.html). So no additional DB configuration required.
- `shema.sql` file contains the database creation script
- `test-data.sql` creates some data fixtures
- both `schema.sql` and `test-data.sql` are referenced in `datasource-tx-jpa.xml`, **their declaration order is IMPORTANT !**

#### TODO's

- add CRUD for Comment resource 
- add flash messages for succes and validation errors
- tests

#### Running

Run `mvn clean install` to download all the dependencies and initialize the project.

To run on Tomcat server:

- either copy the generated `war` (it is in the project's **target** directory) into Tomcat's webapp folder
- or deploy it in a standard way via Tomcat's application manager interface.
- or run the project directly from your favorite IDE (usually via `Project-Run` menu).

#### Gotchas

JSF processes all the actions as POST requests. So all the `posting`tags like `h:commandLink` or `h:commandButton`should be placed
inside a `h:form` element, that requires some extra work with CSS. That's why the links to delete a post are not so nicely aligned :).

It seems like it is not possible to process several views in the same bean (controller) like Ruby on Rails does. That's why 
edit/update actions were extracted into a separate PostEditBean class.
