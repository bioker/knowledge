# base configuration
git config --global user.name "Viktor Vlasov"
git config --global user.email "viktorvlasovsiberian@gmail.com"
git config --global alias.hist "log --pretty=oneline --graph --decorate --all"
git config --global alias.l "log --pretty='format:%C(auto)%h %G? %Cgreen%cd%Creset %Cblue%an%Creset %s %C(auto)%d' --graph --all --date=format:%F_%T"
git config --global core.autocrlf input
git config --global core.quotepath false
git config --global push.default simple
git config --global diff.tool vimdiff
git config --global merge.tool vimdiff
git config --global merge.conflictstyle diff3
git config --global mergetool.prompt false
git config --global user.signingkey C1A1019C
git config --global commit.gpgsign true
