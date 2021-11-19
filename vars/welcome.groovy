def call(){
   node('master'){
        stage ("welcome"){
             println "welcome to the shared library"
        }
   }
}