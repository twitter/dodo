.. Author notes: this file is formatted with restructured text
  (http://docutils.sourceforge.net/docs/user/rst/quickstart.html).

Note that ``PHAB_ID=#`` and ``RB_ID=#`` correspond to associated messages in commits.

Unreleased
----------

23.11.0
-------

No Changes

22.12.0
-------

No Changes

22.7.0
------

No Changes

22.4.0
------

No Changes

22.3.0
------

No Changes

22.2.0
------

No Changes

22.1.0
------

No Changes

21.12.0
-------

No Changes

21.11.0
-------

No Changes

21.10.0
-------

No Changes

21.9.0
------

No Changes

21.8.0 (No 21.7.0 Release)
--------------------------

No Changes

21.6.0
------

No Changes

21.5.0
------

No Changes

21.4.0
------

No Changes

21.3.0
------

Runtime Behavior Changes
~~~~~~~~~~~~~~~~~~~~~~~~

* dodo - Revert to scala version 2.12.12 due to https://github.com/scoverage/sbt-scoverage/issues/319
  ``PHAB_ID=D635917``

* dodo - Bump scala version to 2.12.13 ``PHAB_ID=D632567``

Added
~~~~~

* dodo - Add initial support for JDK 11 compatibility. 
  Update SBT and Scala versions to be JDK 11 compatible
  ``PHAB_ID=D365075``

* dodo - Clean the ivy cache (~/.ivy2/cache/com.twitter) of any twitter-oss
  project after running an sbt update to ensure that we resolve any locally
  built version. Better logging and ensure `openssl` is installed before 
  attempting to run the script. ``PHAB_ID=D121300``

* dodo - Introduce the `--clean-files` directive which will delete Dodo caches before 
  runnning a Dodo build. Additionally, we update the `--clean` directive to include removing 
  any sbt-launch.jar to aid in sbt version upgrades. ``PHAB_ID=D106719``

Changed
~~~~~~~

Fixed
~~~~~

Closed
~~~~~~

dodo-0.0.1
----------

Added
~~~~~

* dodo - Add ability to publish artifacts to local m2 repository. ``RB_ID=908296``
* dodo - Add ability to clean, set remote branch and fix md5 hashing. ``RB_ID=866019``
* dodo - Add retry to commands to deal with maven.twttr.com intermittent issues. ``RB_ID=860952``
* dodo - Initial commit of Dodo -- Twitter OSS Project Builder. ``RB_ID=852751``

Changed
~~~~~~~

Fixed
~~~~~

Closed
~~~~~~
