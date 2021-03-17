## Dodo

[![Build Status](https://github.com/twitter/dodo/workflows/continuous%20integration/badge.svg?branch=develop)](https://github.com/twitter/dodo/actions?query=workflow%3A%22continuous+integration%22+branch%3Adevelop)
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

### Usage

The builder will build and locally publish via [sbt][sbt] all the Twitter OSS dependencies of the given target project (and optionally the given project as well).

There are two main modes to usage: `local` or `remote`. By default Dodo works in the `remote` mode, meaning it assumes that the Twitter OSS dependencies are meant to be downloaded from their remote locations in [Github](https://github.com/twitter). Dodo attempts to be somewhat smart and not clone repositories from Github if it already has a copy that is up-to-date with the latest SHA found in the remote repository.

Additionally, in `remote` mode Dodo attempts to cache commands it has run against the local SHA. If it finds that it has run the given commands against the currently cached SHA for a repository it will not run them again. See the [Clean Up](#clean-up) section for more information.

If you want to bypass this caching you can work in `local` mode (which is generally faster). This mode assumes that all of the relevant projects exist on the local filesystem in directories relative to where the bin/build script is run. This mode does not do any type of caching.

#### Example command:

```bash
$ ./dodo/bin/build --no-test finagle
```

The above command will clone all necessary Github Twitter OSS repos for building Finagle (util and scrooge), build, and publish them locally such that you can build your copy of Finagle against the locally published dependencies. Since `--no-test` is passed it will compile but not run each project's tests.

If you want to pass an option that take a value, e.g., `--sbt-version`, use a space. E.g.,

```bash
$ ./dodo/bin/build --no-test --scala-version 2.12.12 finagle
```

Builder options:

```
--all             Build all projects in the DAG list (overrides --include).
                  Default: false.
--clean           Delete any sbt-launch.jar and run `sbt clean` before running other sbt commands. Default: false.
--clean-files     Delete all Dodo caches, e.g., $DODO_DIRECTORY/caches, $DODO_DIRECTORY/clones,
                  and $DODO_DIRECTORY/builds. Default: false.
--include         Include building of the given project. Default: false.
--no-test         Do not run tests (will still compile tests via test:compile).
                  Default: false (run tests).
--scala-version   If set, do not cross-compile instead use this specific version for building all projects.
                  Default: unset (cross-compile).
--clone-dir       Directory into which to clone remotes. Default: $HOME/.dodo/clones
--local           Build source from local filesystem instead of Github.
                  Default: false (use Github sources).
--branch          Branch to use when building from Github sources. Default: develop.
--proxy           Base URL from which to resolve artifacts when working offline, (e.g., the sbt-launch.jar),
                  Example: --proxy https://my.internal.company.repo/sbt-repo. NOTE: you MUST set
                  --local and --sbt-version with this option. Default: unset.
--publish-m2      Also publish artifacts to the local ~/.m2 repository. Default: false.
--sbt-version     The sbt version to use when downloading the sbt launch jar.
                  Default: unset, the project defined sbt version will used.
--dry-run         Output, but do not execute the sbt build commands. If using remotes
                  they will still be cloned. Default: false.
--verbose         Run in verbose mode. Default: false.
--trace           Run in trace mode. Note: extremely verbose. Default: false.
--help            Print usage.
project           [OPTIONAL] Individual project for which to build all dependencies.
                  Optional if '--all' is passed. Required otherwise."
```

### <a name="clean-up" href="#clean-up">Clean Up</a>

The Dodo script maintains some state in $HOME/.dodo. This state is maintained when working in `remote` mode. These are:

```
$ ~/.dodo/build
$ ~/.dodo/caches
$ ~/.dodo/clones
```

To clean up this state, simply delete these directories or include the `--clean-files` option. Note, the `~/.dodo/clones` directory contains all previously cloned repositories.

## License

Copyright 2016 Twitter, Inc.

Licensed under the Apache License, Version 2.0: https://www.apache.org/licenses/LICENSE-2.0

[util]: https://github.com/twitter/util
[scrooge]: https://github.com/twitter/scrooge
[finagle]: https://github.com/twitter/finagle
[twitter-server]: https://github.com/twitter/twitter-server
[finatra]: https://github.com/twitter/finatra
[sbt]: https://www.scala-sbt.org/
