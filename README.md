Before running tests you need to [clone and run an application](https://github.com/PavelMal/PostmanTesting) using docker-compose.

You can use tests in parallel by adding param `-Psuite="Parallel"`also you can configure thread amount by adding param `-Pthreads="2"` into 'arguments'. 

In case of no additional params tests will start with default configuration (Single thread with a 'Single' suite).
Also added params `-Pprotocol` and `-Phost` to configure a protocol and a host, for example: 

 - `-Pprotocol="https"`
 - `-Phost="mytest.com"`

To see an allure report after passing the automated tests, you need to follow the instruction:

 - Run tests (when tests finish you will see a new folder 'build' inside a project, inside 'build' folder you will see 'allure-results' folder) 

 - Change your directory into 'build' and run a command `allure serve` (report will be formed automatically)