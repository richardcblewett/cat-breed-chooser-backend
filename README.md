# Cat Breed Chooser Backend

This project is the backend for the cat breed chooser app frontend available here: https://cat-breed-chooser.herokuapp.com.<br>

The purpose of this app is to supply data that originated from [thecatapi](https://thecatapi.com) to the frontend application. Using a backend rather the api directly allows the data processing to happen on a server rather than use the client resources.
<br><br>

# Installation Instructions
If you would like install this project on your computer rather than use the online version hosted at https://cat-breed-chooser-backend.herokuapp.com, you may clone this repository to your computer. (Also feel free to check out the frontend repository at https://github.com/richardcblewett/cat-breed-chooser)

After cloning the repository, make sure you have the dependencies installed before following the instructions on how to run the project.

## Dependencies
- An IDE that can interface with springboot (such as VSCode or IntelliJ IDEA)
- Git (https://git.scm.com/downloads)
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

# Technologies Used
- Git
- Lucid.app (ERD design)
- PostGreSQL
- Postman
- VS Code (IDE)
- IntelliJ IDEA (IDE)
<br><br>

# Design

My original design for the backend was to have a database table for basic cat breed characteristics, another database table for the breed description in order to not overwhelm the first table, and then to have a third table to store some keywords associated with breeds. (This last item was to be an implementation option after achieving MVP.)<br>

Seeding the database was accomplished by opening an api endpoint (by removing security) that would immediately call thecatapi and adding the results of the "give me all thecatapi breeds" call to the database. Results from the external api call were added to the database as long as the breed had a name, had a photo, and the photo was accessible to the backend.<br> 

After deploying the backend, I realized I have no idea if the database performance would be improved by giving breed descriptions their own database, so I pivoted from my original ERD designs and refactored the databases from 2 down to 1.<br>

## ERD Diagrams
| Original                                                            | Final                                                          |    
|---------------------------------------------------------------------|----------------------------------------------------------------|    
| <img src="./planning/CatBreedChooserERD-ORIGINAL.png" height=300px> | <img src="./planning/CatBreedChooserERD-MVP.png" height=300px> |  
<br>

## Searching
Rather than create a new JPA Query for every specific combination of parameters, for the most part I chose to use one query that would return all breeds and then filter out the breeds that did not meet the input criteria. I chose to do things this way because some of my earlier query attempts were returning errors and this was another way to give me the results I was looking for.<br>

As the old adage goes: "There's more than one way to skin a cat." <br>

## Security
Spring security is included in the code, but not fully implemented. I chose to have everything ready in case there was time to implement user logins and user profiles - but there was not. 
<br><br>
