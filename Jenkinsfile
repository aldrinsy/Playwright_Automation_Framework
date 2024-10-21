pipeline 
{
    agent any
    
    tools{
		//Ito yung mga makikita sa TOOLS  (Configure tools, their locations and automatic installers.)
    	maven 'MAVEN_HOME'    // MAVEN_HOME: Ito yung name sa Maven installations while path nun is eto: C:\Program Files\apache-maven-3.9.9
        }

    stages 
    {
        stage('Build') 
        {
            steps{
                echo("Dev: Trigger Unit Testing")
            }
        }
        
        
        
        stage("Deploy to QA"){
            steps{
                echo("Dev: Deploying Code to Q.A Environment")
            }
        }
                
        stage('Regression Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git branch: 'main', url: 'https://github.com/aldrinsy/Playwright_Automation_Framework'
                    //use "bat" if you are using windows while use "sh" if you are using mac
                    bat "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regressions.xml"
                    
                }
            }
        }
        
        
        stage('Publish Extent Report'){
            steps{
                     publishHTML([allowMissing: false,
                                  alwaysLinkToLastBuild: false, 
                                  keepAll: true, 
                                  reportDir: 'ExtentReport', 
                                  reportFiles: 'TestExecutionReport.html', 
                                  reportName: 'HTML Extent Report', 
                                  reportTitles: ''])
            }
        }
        
        
        
        
    }
}