package org.asteriskjava.pbx.internal.asterisk.wrap.userEvents;

import org.apache.log4j.Logger;
import org.asteriskjava.pbx.Channel;
import org.asteriskjava.pbx.PBXFactory;
import org.asteriskjava.pbx.internal.asterisk.InvalidChannelName;
import org.asteriskjava.pbx.internal.asterisk.wrap.events.ManagerEvent;
import org.asteriskjava.pbx.internal.core.AsteriskPBX;

public class UserEvent extends ManagerEvent
{
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(UserEvent.class);

    private Channel channel;

    public UserEvent(org.asteriskjava.manager.event.UserEvent source, Channel channel)
    {
        super(source);
        this.channel = channel;
    }

    public UserEvent(org.asteriskjava.manager.event.UserEvent event) throws InvalidChannelName
    {
        super(event);

        AsteriskPBX pbx = (AsteriskPBX) PBXFactory.getActivePBX();
        this.channel = pbx.internalRegisterChannel(event.getChannel(), event.getUniqueId());
    }

    public Channel getChannel()
    {
        return this.channel;
    }
}
