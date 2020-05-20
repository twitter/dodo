import com.jsuereth.sbtpgp.PgpKeys.pgpPassphrase

credentials in Global += Credentials("Sonatype Nexus Repository Manager",
  "oss.sonatype.org",
  sys.env("SONATYPE_USERNAME"),
  sys.env("SONATYPE_PASSWORD"))

pgpPassphrase in Global := Some(sys.env("PGP_PASSPHRASE").toCharArray)
