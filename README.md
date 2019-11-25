## Description
I decided to create this app because I've found reading fanfiction on fanfiction.net can be annoying sometimes.  I've often wished I had features like knowing which chapters I've already read.  I wanted to create a minimalist interface for reading that had all the features I wanted.

Currently the app pulls stories (favorite list) off of fanfiction.net(user: Samghost) for offline viewing.  Has a clean, simple interface to read stories (material design guidelines color palette). Custom app icon.

Future intended functionality: Uses Google for authorizing (currently nonfunctional), marks chapters already read as READ, marks story as READ when all chapters have been read, database full functional and stories persist without internet connection (currently internet connection is necessary).

## Intended Users
Readers of fanfic who want useful features like offline reading and tracking chapters and stories already read.

## Requirements
* Android SDK build minimum 21.  Tested on SDK 27,28. Hardware: Pixel2(Emulator) and Samsung SM-T290.
* Jsoup, GoogleSignIn
* Internet Connection

## Build Instructions
1. Clone the repo git@github.com:sm-heard/fanficio.git
2. Import into Intellij
3. Build with gradle
4. Run with "app" config

## Resources

[User stories](docs/user-stories.md)  
[Wireframes](docs/wireframe.md)  
[ERDs](docs/erd.md)  
[DDL](docs/ddl.md)  
[License](docs/license-info.md)   
[User Instructions](docs/user_instructions.md)   
[JavaDocs](docs/index.html)
[Demo](docs/demo.gif)

## First milestones
* [x] Description
* [x] Intended Users
* [x] ERDs
* [x] Wireframes
* [x] User Stories

## Second milestones
* [x] Description
* [x] Intended Users
* [x] ERDs
* [x] Wireframes
* [x] User Stories
* [x] Entity Classes
* [x] DAO Interfaces
* [x] Database Class
* [x] DDL
* [x] Chrome Inspectablity

## Third Milestone
* [x] Documentation
* [x] Implementation Components
