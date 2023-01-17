# AliceInWonderland

All functions (should) be replaced by a stream equivalent.

compile-step (Completed in 5 seconds)
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< uk.ac.cam.mh2169:alice >-----------------------
[INFO] Building alice 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ alice ---
[INFO] 
[INFO] --- jacoco-maven-plugin:0.8.5:prepare-agent (default) @ alice ---
[INFO] argLine set to -javaagent:/home/user/.m2/repository/org/jacoco/org.jacoco.agent/0.8.5/org.jacoco.agent-0.8.5-runtime.jar=destfile=/mnt/pottery/SUBMISSION/target/jacoco.exec
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ alice ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 4 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ alice ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /mnt/pottery/SUBMISSION/target/classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.653 s
[INFO] Finished at: 2023-01-17T08:12:58Z
[INFO] ------------------------------------------------------------------------
execute-tests (Completed in 5 seconds)
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< uk.ac.cam.mh2169:alice >-----------------------
[INFO] Building alice 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- jacoco-maven-plugin:0.8.5:prepare-agent (default) @ alice ---
[INFO] argLine set to -javaagent:/home/user/.m2/repository/org/jacoco/org.jacoco.agent/0.8.5/org.jacoco.agent-0.8.5-runtime.jar=destfile=/mnt/pottery/SUBMISSION/target/jacoco.exec
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ alice ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 4 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ alice ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ alice ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /mnt/pottery/SUBMISSION/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ alice ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /mnt/pottery/SUBMISSION/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ alice ---
[INFO] Surefire report directory: /mnt/pottery/SUBMISSION/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running uk.ac.cam.mh2169.alice.AliceTest
Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.268 sec

Results :

Tests run: 10, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.691 s
[INFO] Finished at: 2023-01-17T08:13:04Z
[INFO] ------------------------------------------------------------------------
test-rewrite (Completed in 2 seconds)
Test harness binary found
Compiled submission found

- Running test countWords_returns0_forEmptyList
- Creating input list
- Invoking static method uk.ac.cam.mh2169.alice.Alice.countWords([])

- Running test countWords_returns0_whenOnlyPunctuation
- Creating input list
- Invoking static method uk.ac.cam.mh2169.alice.Alice.countWords([.(.:1.0),,(,:1.0)])

- Running test countWords_returns3_whenThreeWords
- Creating input list
- Invoking static method uk.ac.cam.mh2169.alice.Alice.countWords([Alice(NNP:1.0),Queen(NNP:1.0),King(NNP:1.0)])

- Running test leastConfidentToken_findsSmallestConfidence
- Creating input list
- Invoking static method uk.ac.cam.mh2169.alice.Alice.leastConfidentToken([Most(NNP:1.0),Least(NNP:0.1),Middle(NNP:0.5)])
- Invoking instance method token.contents()

- Running test posFrequencies_producesCorrectCount
- Creating input list
- Invoking static method uk.ac.cam.mh2169.alice.Alice.posFrequencies([Alice(NNP:1.0),Alice(NNP:1.0),Queen(NNP:1.0),the(DET:1.0)])

- Running test properNouns_returnsTop2Names
- Creating input list
- Invoking static method uk.ac.cam.mh2169.alice.Alice.properNouns([Alice(NNP:1.0),Alice(NNP:1.0),Queen(NNP:1.0),King(NNP:1.0),King(NNP:1.0),the(DET:1.0),the(DET:1.0),the(DET:1.0)],2)

- Running test topN_returnsAll_ifNotEnoughPresent
- Invoking static method uk.ac.cam.mh2169.alice.Alice.topN(10,[banana=1,pear=5,apple=10])

- Running test topN_returnsTopOne
- Invoking static method uk.ac.cam.mh2169.alice.Alice.topN(1,[banana=1,pear=5,apple=10])

- Running test vocabulary_ignoresCase
- Creating input list
- Invoking static method uk.ac.cam.mh2169.alice.Alice.vocabulary([Alice(NNP:1.0),alice(NNP:1.0),Queen(NNP:1.0),King(NNP:1.0),King(NNP:1.0)],2)

- Running test vocabulary_ignoresPunctuation
- Creating input list
- Invoking static method uk.ac.cam.mh2169.alice.Alice.vocabulary([Alice(NNP:1.0),Alice(NNP:1.0),Queen(NNP:1.0),King(NNP:1.0),.(.:1.0),.(.:1.0),.(.:1.0)],1)

- Running test vocabulary_returnsTop2Words
- Creating input list
- Invoking static method uk.ac.cam.mh2169.alice.Alice.vocabulary([Alice(NNP:1.0),Alice(NNP:1.0),Queen(NNP:1.0),King(NNP:1.0),King(NNP:1.0)],2)

- Running test vocabulary_worksWithFewer
- Creating input list
- Invoking static method uk.ac.cam.mh2169.alice.Alice.vocabulary([Alice(NNP:1.0)],2)

Pass: 12 out of 12 tests passed
check-test-coverage (Completed in 3 seconds)
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< uk.ac.cam.mh2169:alice >-----------------------
[INFO] Building alice 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- jacoco-maven-plugin:0.8.5:report (default-cli) @ alice ---
[INFO] Loading execution data file /mnt/pottery/SUBMISSION/target/jacoco.exec
[INFO] Analyzed bundle 'alice' with 3 classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.400 s
[INFO] Finished at: 2023-01-17T08:13:10Z
[INFO] ------------------------------------------------------------------------


Coverage report

uk.ac.cam.mh2169.alice.Alice                      96%
uk.ac.cam.mh2169.alice.Token                      100%
--
OVERALL                                           97%
--
REQUIRED                                          90%
