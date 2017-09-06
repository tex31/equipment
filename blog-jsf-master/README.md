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
- port default mysql
- db name tay

#### TODO's

- exception
- view
- metier

#### Running

mvn project

To run on Tomcat server:

- either copy the generated `war` (it is in the project's **target** directory) into Tomcat's webapp folder
- or deploy it in a standard way via Tomcat's application manager interface.
- or run the project directly from your favorite IDE (usually via `Project-Run` menu).

