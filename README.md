## heroku-gradle-subprojects

#### Purpose
This project demonstrates using the `heroku-buildpack-gradle` project to toggle running different subprojects via an environment variable.

#### Requirements

- gradle
- [heroku-buildpack-gradle](https://github.com/heroku/heroku-buildpack-gradle)
- heroku application

This project uses the environment variable `PROJECT` to select which project to build. Once the project is built, it moves the project to the root directory and renames the files to a generic name that the `Procfile` can evoke.

In the `build.gradle` file, apply the 'application' gradle plugin. The `runtimeProjectName` is a placeholder name for the project that heroku will run. The `runtimeDestination` sets where to move the built project. The `theMainClassName` maps project names to the main class name.

You can see a project being built by running:
```bash
$ PROJECT={projectName} ./gradlew stage
```

The project will be moved to `./build/project`

#### Running on Heroku

1. Create a HerokuApp
2. Set the environment variable `PROJECT` to the project you want to run
3. Deploy the application


#### Examples

- [project-one](https://subproject1.herokuapp.com/)
- [project-two](https://subproject2.herokuapp.com/)