#!/bin/bash
filename='cvss.txt'
while read cvss; do
compare=`echo | awk "{ print ($threshold < $cvss)?1 : 0 }"`

if [[ $compare -eq 1 ]]; then
        echo "Vulnerability has higher CVSS score than the threshold. Exiting..."
        exit 1
else
	echo "Vulnerability has lesser CVSS score than the threshold. Proceeding..."
fi
done < "$filename"
