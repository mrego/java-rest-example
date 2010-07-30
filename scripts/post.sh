
if [ $# -ne 1 ]
then
	echo "ERROR: Missing file" 1>&2
	echo "Use: $0 file-name" 1>&2
	exit 1
else
	file=$1
fi

curl -sv -X POST -d @$file --header "Content-type: application/xml" \
	http://localhost:8080/java-rest-example/rest/messages/
