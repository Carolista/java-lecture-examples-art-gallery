# java-lecture-examples-art-gallery

#### Lecture examples for chapters 9-10, 13-15, and 17-20: a Spring Boot Java application with Thymeleaf and MySQL

Use individual branches to `git checkout` **starter code** or **solution** for each class. 

_Note: There is no starter code for class 8 because the project is meant to be created with Spring Initializr as part of the lecture example._

### HOW TO PULL DOWN CHANGES AFTER FORKING

If I make changes to the source code in my original repo after you have forked your own copy, you can follow these instructions to pull in my changes on your local machine:

#### STEP 1:
If you have not yet set the upstream connection, do this first in the terminal inside your forked repository:

```
git remote add upstream https://github.com/Carolista/java-lecture-examples-art-gallery
```

Now you have two remotes, `origin` (your fork) and `upstream` (my original repo)

#### STEP 2:
In order to pull in changes locally, you will need to fetch anything new from my repo:

```
git fetch upstream
```

#### STEP 3:
For any branch you wish to update, first switch to that branch, then merge in my changes.

```
git checkout branch-name
git merge upstream/branch-name
```

If you run into merge conflicts, accept the incoming changes from upstream. If you have to manually edit the conflicts before finishing the merge commit, use my [original repo](https://github.com/Carolista/java-lecture-examples-art-gallery) as a guide.
