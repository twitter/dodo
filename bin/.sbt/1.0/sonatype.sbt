credentials in Global += Credentials("Sonatype Nexus Repository Manager",
  "oss.sonatype.org",
  sys.env("SONATYPE_USERNAME"),
  sys.env("SONATYPE_PASSWORD"))
