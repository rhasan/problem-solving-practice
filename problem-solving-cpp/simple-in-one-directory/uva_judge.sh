PROB=$1
echo "Judging UVA problem: "$PROB
rm -f $PROB.o
COMPLIE=$(g++ -o $PROB.o uva-$PROB.cpp)
if [ "$?" != "0" ]
then
	echo $COMPLIE
	exit 1
fi
./$PROB.o < input/$PROB.in > out/my$PROB.out
if [ "$?" != "0" ]
then
	exit 1
fi


DIFF=$(diff out/my$PROB.out out/$PROB.out)
if [ "$?" != "0" ]
then
	echo $DIFF
	exit 1
fi

if [ "$DIFF" != "" ] 
then
    echo "Incorrect output :("
    echo $DIFF
else
	echo "Correct output!"
fi
