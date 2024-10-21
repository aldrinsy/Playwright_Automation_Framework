pipeline 
{
    agent any
    
    tools{
    	maven 'MAVEN_HOME'
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
                    git 'https://github.com/aldrinsy/Playwright_Automation_Framework'
                    sh "mvn clean test"
                   //sh "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regressions.xml"
                    
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