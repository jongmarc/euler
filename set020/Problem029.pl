use bignum;

for ($i=2; $i <= 100; $i++) {
	for ($j=2; $j <= 100; $j++) {
		$matrix{$i**$j} = 1;
	}
}
print scalar(keys %matrix);