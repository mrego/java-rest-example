
if [ $# -ne 2 ]
then
	echo "ERROR: Missing index or file" 1>&2
	echo "Use: $0 index file-name" 1>&2
	exit 1
else
	index=$1
	file=$2
fi

curl -sv -X PUT -d @$file --header "Content-type: application/xml" \
	http://localhost:8080/java-rest-example/rest/messages/$1
