# mvnu_cs_utility
This is a simple wrapper library for use in CS1/2 courses at MVNU. There are Netbeans 8 (Ant, under the Ant folder) and Netbeans 12 (Maven, under MVNU_CS_Utility_Library folder)   based builds. For courses with a Spring 2020 start date, the Maven based build is needed without restoring to complex JavaFx installs. 

1. Checkout project using your preferred git client
2. Open the Maven based project in Netbeans
3. Click Run-->Build Project
4. Look in the target folder for the jar file that you install into your local maven repository using mvn

./mvn -X install:install-file "-Dfile=c:\projects\MVNU CS Utility Library\dist\MVNU_CS_Utility_Library.jar" "-DgroupId=mvnu.cs" "-DartifactId=mvnu_cs_util" "-Dversion=0.1" "-Dpackaging=jar" "-DgeneratePom=true"

You'll need to adjust the name of file parameter to match

5. Add the depdendency to your current Netbeans 12+ Maven based JavaFx project by right-clicking on Dependencies and select add dependency. Fill out the fields to match the above command line parameters and select runtime as your scope. 

This should give you a new dependency entry called mvnu_cs_util-0.1.jar under dependencies

6. Right-click on the new dependency entry and select "Manually Install Artifact." Click the Browse button and move to the directory where the jar file is located, click OK.

7. Add "requires mvnu.cs.util;" to your module-info.java file in your project. 

8. Clean and Build

9. Run
