def newgit(repo)
{
  git "${repo}" 
} 
def newmaven()
{
  sh 'mvn package' 
}
def deploy(ip,appname)
{
  sh "scp /home/ubuntu/.jenkins/workspace/descriptivepipeline2/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat9/webapps/${appname}.war"
} 
def runselenium(path)
{
  sh "java -jar ${path}/testing.jar"

}  
def needapprovals(name)
{
  input message: 'waiting for approval!', submitter: "${name}"
}  
