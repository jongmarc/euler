$answer = 28433;


for ($i = 1; $i <= 7830457; $i++){
	$answer = ( $answer * 2 ) % 10000000000
}  
$answer++;
print "Answer = ".$answer;  