# mvnu_cs_utility
A Java utility library for CS1/2 courses or where needed

1. Clone repo
2. Import/Open project in Netbeans
3. Build project to generate jar
4. Add jar library into current project needing this library by right clicking on it, selecting Properties, and then Libraries
5. Click "Add JAR/folder" and navigate to where the jar file was generated, click ok.

<br/>
On step 4 above, you may be better off copying the jar file into each project needing it and then adjusting the Project Properties to point to it. So, create a lib directory in your project, copy the MVNU CS Utility jar file into the lib dierectory, and then go into your Project Properties --> Libraries --> Add Jar/Folder

Usage: <br/>
* To display a dialog message, for example, use: FXOptionPane.showMessageDialog("Bad Input", "Try again",<Exception object>.getMessage()); <br/>
