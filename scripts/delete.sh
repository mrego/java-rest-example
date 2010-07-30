
if [ $# -ne 1 ]
then
	echo "ERROR: Missing index" 1>&2
	echo "Use: $0 index" 1>&2
	exit 1
else
	index=$1
fi

curl -sv -X DELETE --header "Content-type: application/xml" \
	http://localhost:8080/java-rest-example/rest/messages/$index | tidy -xml -i -q -utf8
