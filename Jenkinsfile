pipeline 
{
    agent any
    
    tools{
		//Ito yung mga makikita sa TOOLS  (Configure tools, their locations and automatic installers.)
    	maven 'MAVEN_HOME'    // MAVEN_HOME: Ito yung name sa Maven installations while path nun is eto: C:\Program Files\apache-maven-3.9.9
    	git 'GIT_BASH'         // GIT_BASH: Ito yung name sa Git Installation, while yung path nun is eto: C:\Program Files\Git\cmd\git.exe
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
                    sh "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regressions.xml"
                    
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