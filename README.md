<h1>FinalSurge automatic tests</h1>

<h2>What is FinalSurge?</h2>

FinalSurge.com is the training and coaching platform that empowers athletes and coaches to reach fitness and performance excellence like never before.
The FinalSurge makes it so easy to track workouts and the workout tracking contains the detailed data needed to optimize your training to get maximum results without injury.


<h2>Prerequisites installed</h2>
<p> 1. Java JDK 1.11</p> 
<p> 2. Maven </p>  

<h2>Setting up config</h2>
<p>1. Clone this repository.</p>
<p>2. Enter your email and password in config.properties.</p>
<p>3. You can specify the browser (Chrome or Firefox) you want to use in the parameters "browser" of the regression.xml, negative.xml, smoke.xml files, the default is Chrome.</p>

<h2>Checklist</h2>
<p>1. Verify that user can log in the system.</p>
<p>2. Verify that user can't log in the system with invalid password or email.</p>
<p>3. Verify that user can log out of the system.</p>
<p>4. Verify that user can add workout.</p>
<p>5. Verify that user can add equipment.</p>
<p>6. Verify that user can use ‘Other Calculators’ to calculate daily caloric needs.</p>
<p>7. Verify that user can use ‘Other Calculators’ to calculate pace.</p>
<p>8. Verify that user can use ‘Workout Calculators’ to calculate the intensity of a running workout.</p>
<p>9. Verify that user can use 'Workout Calculators' to calculate Tinman's running by Tom Schwartz.</p>
<p>10. Verify that user can use 'Workout Calculators' to calculate the pace of Hanson's marathon method.</p>
<p>11. Verify that user can view daily vitals for the selected time period.</p>
<p>12. Verify that user can report on workouts of the selected type for the selected period.</p>
<p>13. Verify that user can open print page with workouts for the selected time period.</p>

<h2>Test suites</h2>
<h3>Regression tests</h3>
<p>This suite includes all tests from files: LogoutTest, DailyVitalsTest, OtherCalculatorsTest, PrintWorkoutsTest, WorkoutCalculatorsTest. </p> 
<h4>Running the suit</h4>
<p> To execute the test suite, simply run: </p> 
<p> mvn -Dtest=regression.xml test </p> 
<p>And each scenario of this suite will execute. </p> 

<h3>Smoke tests</h3>
<p> This suite includes tests from files: LoginTest, WorkoutReportTest, AddWorkoutTest, EquipmentTest. </p> 
<h4>Running the suit</h4>
<p> To execute the test suite, simply run: </p> 
<p> mvn -Dtest=smoke.xml test </p> 
<p>And each scenario of this suite will execute. </p> 

<h3>Negative tests</h3>
<p>This suite includes loginNegativeTest with 3 variants of input data.</p> 
<h4>Running the suit</h4>
<p> To execute the test suite, simply run: </p> 
<p> mvn -Dtest=negative.xml test </p> 
<p>And each scenario of this suite will execute. </p> 

<h2>Running tests</h2>
<h4>Run tests using mvn clean test command</h4>
<p> mvn clean test </p>

<h4>Running a single test and running a set of methods in a single test class</h4>
<p>1. mvn -Dtest=LogoutTest test</p>
<p>2. mvn -Dtest=OtherCalculatorsTest#paceCalculatorTest test  </p>
<p>3. mvn -Dtest=WorkoutCalculatorsTest#calculateIntensityTest+calculateHansonsTest test  </p> 


