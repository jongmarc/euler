$answer = 0;
for ($i = 0; $i < 10000; $i++) {
	$found = 0;
	$k = $i;
	for ($j = 0; $j < 50; $j++) {	
		$k += reverse $k;
		if ($k == reverse $k) {
			$found = 1;
			last;
		} 
		
	}
	if (!$found) {
		print "Found lychrel number ".$i."\n";
		$answer++;
	}
}
print "Answer = ".$answer."\n";