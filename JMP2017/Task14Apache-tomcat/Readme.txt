1) Install Apache 2.4
2) inject mod_jk into Apache24\modules\
3) create worker.properties into Apache24\conf(file commited)
4) add string LoadModule jk_module modules/mod_jk.so into httpd.conf
5) add into httpd.conf:
JkMount  /examples/jsp/*.html worker1
JkMount  /examples/jsp/*.jsp worker1

Alias /examples "e:/JMP/static/"
<Directory "e:/JMP/static/">
#    Options Indexes MultiViews
#    AllowOverride None
#    Order allow,deny
#    Allow from all
	Require all granted
</Directory>


6) install tomcat apache-tomcat-8.5.14
7) start apache and tomcat
8) create directory e:/JMP/static/jsp/images/ with gifs from TOMCAT_HOME\webapps\examples\jsp\images\
delete directory TOMCAT_HOME\webapps\examples\jsp\images\

9) try http://localhost/examples/jsp/ 

RESULT: statics content(images) come from APACHE and dynamic content from tomcat. (see result screen)