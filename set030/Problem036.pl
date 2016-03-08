
$sum = 0;
for ($i = 0; $i < 1000000; $i++) {
	$j = reverse $i;
	if ( $i != $j ) {
		next;
	}

	$k = dec2bin($i);
	$l = reverse($k);
	if ($k eq $l) {
		print $i." - ".$k."\n";
		$sum += $i;
	}

}
print "Answer = ".$sum."\n";
sub dec2bin {
    my $str = unpack("B32", pack("N", shift));
    $str =~ s/^0+(?=\d)//;   # otherwise you'll get leading zeros
    return $str;
}
sub bin2dec {
    return unpack("N", pack("B32", substr("0" x 32 . shift, -32)));
}