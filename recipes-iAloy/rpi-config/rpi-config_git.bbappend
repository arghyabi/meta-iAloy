do_deploy_append() {
echo "hdmi_force_hotplug=1" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
echo "hdmi_group=2" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
echo "hdmi_mode=1" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
echo "hdmi_mode=87" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
echo "hdmi_cvt 1024 600 60 6 0 0 0" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
echo "max_usb_current=1" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
echo "config_hdmi_boost=7" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
echo "hdmi_drive=1" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
echo "display_rotate=0" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
}