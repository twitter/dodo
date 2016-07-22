## Dodo

[![Build Status](https://secure.travis-ci.org/twitter/dodo.png?branch=develop)](http://travis-ci.org/twitter/dodo?branch=develop)
[![Project status](https://img.shields.io/badge/status-active-brightgreen.svg)](#status)
[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/twitter/finagle)

<img src="./dodo-bird.jpeg"/>

### About

When working with the [Finagle][finagle] family of Twitter OSS projects it is sometimes necessary to be able to easily build a project against the `develop` branch of the other Twitter OSS repositories.

This repository contains a script to help users build and test the [Finagle][finagle] family of open-source projects. This includes the projects:

[Util][util]  
[Scrooge][scrooge]  
[Finagle][finagle]  
[TwitterServer][twitter-server]  
[Finatra][finatra]  
[Ostrich][ostrich]  

### Usage

The builder will build and locally publish via [sbt][sbt] all the Twitter OSS dependencies of the given target project (and optionally the given project as well). 

There are two main modes to usage: `local` or `remote`. By default Dodo works in the `remote` mode, meaning it assumes that the Twitter OSS dependencies are meant to be downloaded from their remote locations in [Github](https://github.com/twitter). Dodo attempts to be somewhat smart and not clone repositories from Github if it already has a copy that is up-to-date with the latest SHA found in the remote repository. 

Additionally, in `remote`-mode Dodo attempts to cache commands it has run against the local SHA. If it finds that it has run the given commands against the currently cached SHA for a repository it will not run them again. See the [Clean Up](#clean-up) section for more information.


If you want to by-pass this caching you can work in `local`-mode (which is generally faster). This mode assumes that all of the relevant projects exist on the local filesystem in directories relative to where the bin/build script is run. This mode does not do any type of caching.

#### Example command:

```bash
$ ./bin/build --no-test finagle
```

The above command will clone all necessary Github Twitter OSS repos for building Finagle (util, ostrich, and scrooge), build, and publish them locally such that you can build your copy of Finagle against the locally published dependencies. Since `--no-test` is passed it will compile but not run each project's tests.

If you want to pass an option that take a value, e.g., `--sbt-version`, use a space. E.g.,

```bash
$ ./bin/build --no-test --scala-version 2.11.7 finagle
```

Builder options:

```
--all:				Build all projects in the DAG list (overrides `--include`). Default: false
--include:			Include building of the given project. Default: false.
--no-test:			Do not run tests (will still compile tests via `test:compile`). 
                	Default: false (run tests).
--scala-version:	If set, do not cross-compile instead use this specific version for building 
					all projects. Default: unset (cross-compile).
--clone-dir:		Directory into which to clone remotes. Default: $HOME/.dodo/clones
--local: 			Build source from local filesystem instead of Github. 
                	Default: false (use Github sources).
--proxy:	 		Base URL from which to resolve artifacts when working offline, (e.g., the 
                	sbt-launch.jar), Example: `--proxy https://my.internal.company.repo/sbt-repo`.
                	NOTE: you MUST set `--local` and `--sbt-version` with this option. 
                	Default: unset.
--sbt-version:  	The sbt version to use when downloading the sbt launch jar. Default: unset.
--dry-run: 			Output, but do not excute the sbt build commands. If using remotes 
                	they will still be cloned. Default: false.
--verbose:        	Run in verbose mode. Default: false.
--help:				Print usage. 
```

### <a name="clean-up" href="#clean-up">Clean Up</a>

The Dodo script maintains some state in $HOME/.dodo. This state is maintained when working in `remote`-mode. These are:

```
$ ~/.dodo/build
$ ~/.dodo/caches
$ ~/.dodo/clones
```

To clean-up this state, simply delete these directories. Note, the `~/.dodo/clones` directory contains all previously cloned repositories.

[util]: https://github.com/twitter/util
[ostrich]: https://github.com/twitter/ostrich
[scrooge]: https://github.com/twitter/scrooge
[finagle]: https://github.com/twitter/finagle
[twitter-server]: https://github.com/twitter/twitter-server
[finatra]: https://github.com/twitter/finatra
[sbt]: http://www.scala-sbt.org/