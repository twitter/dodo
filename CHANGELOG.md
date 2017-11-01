# Change Log
All notable changes to this project will be documented in this file. Note that ``RB_ID=#`` and ``PHAB_ID=#`` correspond to associated message in commits.

## [Unreleased]

### Added

* dodo - Introduce the `--clean-files` directive which will delete Dodo caches before 
  runnning a Dodo build. Additionally, we update the `--clean` directive to include removing 
  any sbt-launch.jar to aid in sbt version upgrades. ``PHAB_ID=D106719``

### Changed

### Fixed

### Closed

## [dodo-0.0.1](#)

### Added

* dodo - Add ability to publish artifacts to local m2 repository. ``RB_ID=908296``
* dodo - Add ability to clean, set remote branch and fix md5 hashing. ``RB_ID=866019``
* dodo - Add retry to commands to deal with maven.twttr.com intermittent issues. ``RB_ID=860952``
* dodo - Initial commit of Dodo -- Twitter OSS Project Builder. ``RB_ID=852751``

### Changed

### Fixed

### Closed