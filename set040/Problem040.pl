
$fraction = "0";
$i = 1;
while ( length($fraction)<1000010 ) {
	$fraction .= $i;
	$i++;
}
print substr($fraction, 1, 1 );
print " * ";
print substr($fraction, 10, 1 );
print " * ";
print substr($fraction, 100, 1 );
print " * ";
print substr($fraction, 1000, 1 );
print " * ";
print substr($fraction, 10000, 1 );
print " * ";
print substr($fraction, 100000, 1 );
print " * ";
print substr($fraction, 1000000, 1 );
print " = ";
print substr($fraction, 1, 1 ) * substr($fraction, 10, 1 ) * substr($fraction, 100, 1 ) * substr($fraction, 1000, 1 ) * substr($fraction, 10000, 1 ) * substr($fraction, 100000, 1 ) * substr($fraction, 1000000, 1 );