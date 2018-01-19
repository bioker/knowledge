grep "cpu_insecure\|cpu_meltdown\|kaiser" /proc/cpuinfo && echo "patched :)" \
|| echo "unpatched :("
dmesg | grep "Kernel/User page tables isolation: enabled" \
&& echo "patched :)" || echo "unpatched :("
