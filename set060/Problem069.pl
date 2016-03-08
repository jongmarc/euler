use Math::Prime::Util ':all';
$range = 10**7;

$max = 999999;
$answer = 0;
for ($i = 2; $i < $range; $i++) {

	#print $i / euler_phi( $i )."\n";
	if ( (join "", reverse sort split "", euler_phi( $i )) == (join "", reverse sort split "", $i ) ) {
		print $i." = ".euler_phi($i)."\n";
		if ($i / euler_phi( $i ) < $max) {
			$max = $i / euler_phi( $i );
			$answer = $i;
		}
	}
  }
  print "Answer = $answer\n";
