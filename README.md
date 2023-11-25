## Branching Strategy 🌲

When creating branches, be sure to use the proper naming convention. Each item should be hyphen separated and lowercase.

Example:

```txt
update-readme
```

You can create a new branch and move to it with `git checkout -b new-branch-name`. This will create a copy of whatever branch you started from (typically, it will be the `develop` branch).

You should branch off of the `develop` branch, not `main` as this is where all PRs will point. Be sure your branch is up to date before submitting PRs by running `git rebase develop` while checked out to your branch.

`main` will represent our production-ready, bug-free finalized code. We will merge our individual code by opening a [pull request](https://github.com/maxh1231/board-games/pulls) into `develop`, ensuring that it all works together as intended. Finally, every few days we'll merge `develop` into `main` once `develop` is thoroughly tested.

---

