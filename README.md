# Cat Breed Chooser Backend

This project is the backend for the cat breed chooser app frontend available here: https://cat-breed-chooser.herokuapp.com.<br>

The purpose of this app is to supply data that originated from [thecatapi](https://thecatapi.com) to the frontend application. Using a backend rather the api directly allows the data processing to happen on a server rather than use the client resources.
<br><br>

# Installation Instructions
If you would like install this project on your computer rather than use the online version hosted at https://cat-breed-chooser-backend.herokuapp.com, you may clone this repository to your computer. (Also feel free to check out the frontend repository at https://github.com/richardcblewett/cat-breed-chooser)

After cloning the repository, make sure you have the dependencies installed before following the instructions on how to run the project.

## Dependencies
- An IDE that can interface with springboot (such as VSCode or IntelliJ IDEA)
- git (https://git.scm.com/downloads)
- PostgresSQL (https://www.postgresql.org/download/)

## Run the Project
- Open the cloned project with the IDE.
- Check the configuration settings in ```src/main/resources/application-dev.properties``` and make sure the postgres settings match your own.
<br><br>

### Endpoints:
| Request Type | URL           | Request Body                                   | Request Header      | Action                                                  | Access |   
|--------------|---------------|------------------------------------------------|---------------------|---------------------------------------------------------|--------|
| GET          | /api/breeds   |                                                | Authorization: none | returns a list of all breeds (not used in the frontend) | PUBLIC |
| GET          | /api/pictures |                                                | Authorization: none | returns image references and breed ids                  | PUBLIC |
| GET          | /api/names    |                                                | Authorization: none | returns breed names and breed ids                       | PUBLIC |
| GET          | /api/id       |                                                | Authorization: none | updates an existing movie                               | PUBLIC |
| GET          | /api/search   | child_friendly <br> intelligence <br> grooming | Authorization: none | finds breeds that meet the criteria                     | PUBLIC |
| GET          | /breeds       |                                                | Authorization: none | gets all breeds from thecatapi (hidden by security)     | PUBLIC |
<br><br>
