# How to Contribute

We'd love to get patches from you!

## Workflow

We follow the [GitHub Flow Workflow](https://guides.github.com/introduction/flow/)

1.  Fork Dodo
2.  Check out the `develop` branch
3.  Create a feature branch
4.  Write code and tests for your change
6.  From your branch, make a pull request against `twitter/dodo/develop`
7.  Work with repo maintainers to get your change reviewed
8.  Wait for your change to be pulled into `twitter/dodo/develop`
9.  Delete your feature branch

## Testing

It may be difficult to test changes but please list any testing steps taken in the Pull
Request.

Note that while you will see a [Travis CI][travis-ci] status message in your
pull request, all changes will also be tested internally at Twitter before being merged.

## Issues

When creating an issue please try to ahere to the following format:

    One line summary of the issue (less than 72 characters)

    ### Expected behavior

    As concisely as possible, describe the expected behavior.

    ### Actual behavior

    As concisely as possible, describe the observed behavior.

    ### Steps to reproduce the behavior

    List all relevant steps to reproduce the observed behavior.

## Pull Requests

Comments should be formatted to a width no greater than 80 columns.

Files should be exempt of trailing spaces.

We adhere to a specific format for commit messages. Please write your commit
messages along these guidelines. Please keep the line width no greater than
80 columns (You can use `fmt -n -p -w 80` to accomplish this).

    One line description of your change (less than 72 characters)

    Problem

    Explain the context and why you're making that change.  What is the
    problem you're trying to solve? In some cases there is not a problem
    and this can be thought of being the motivation for your change.

    Solution

    Describe the modifications you've done.

    Result

    What will change as a result of your pull request? Note that sometimes
    this section is unnecessary because it is self-explanatory based on
    the solution.

Some important notes regarding the summary line:

* Describe what was done; not the result
* Use the active voice
* Use the present tense
* Capitalize properly
* Do not end in a period — this is a title/subject
* Prefix the subject with "dodo: " 

## Code Review

The Dodo repository on GitHub is kept in sync with an internal repository at
Twitter. For the most part, this process should be transparent to Dodo users,
but it does have some implications for how pull requests are merged into the
codebase.

When you submit a pull request on GitHub, it will be reviewed by the
Dodo community (both inside and outside of Twitter), and once the changes are
approved, your commits will be brought into Twitter's internal system for additional
testing. Once the changes are merged internally, they will be pushed back to
GitHub with the next sync of internal code to the Twitter Github repositories.

This process means that the pull request will not be merged in the usual way.
Instead a member of the Dodo team will post a message in the pull request
thread when your changes have made their way back to GitHub, and the pull
request will be closed (see [this pull request][pull-example] for an example). The 
changes in the pull request will be collapsed into a single commit, but the authorship
metadata will be preserved.

## Documentation

We also welcome improvements to the Dodo documentation.

[pull-example]: https://github.com/twitter/finagle/pull/267
[travis-ci]: https://travis-ci.org/twitter/dodo

### License
By contributing your code, you agree to license your contribution under the terms of the APLv2:
https://github.com/twitter/dodo/blob/develop/LICENSE