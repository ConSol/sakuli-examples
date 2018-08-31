# Written by WATO
# encoding: utf-8

wato_host_tags += \
[('agent',
  u'Agent type',
  [('cmk-agent', u'Check_MK Agent (Server)', ['tcp']),
   ('snmp-only', u'SNMP (Networking device, Appliance)', ['snmp']),
   ('snmp-v1', u'Legacy SNMP device (using V1)', ['snmp']),
   ('snmp-tcp', u'Dual: Check_MK Agent + SNMP', ['snmp', 'tcp']),
   ('ping', u'No Agent', [])]),
 ('criticality',
  u'Criticality',
  [('prod', u'Productive system', []),
   ('critical', u'Business critical', []),
   ('test', u'Test system', []),
   ('offline', u'Do not monitor this host', [])]),
 ('networking',
  u'Networking Segment',
  [('lan', u'Local network (low latency)', []),
   ('wan', u'WAN (high latency)', []),
   ('dmz', u'DMZ (low latency, secure access)', [])])]

wato_aux_tags += \
[('snmp', u'monitor via SNMP'), ('tcp', u'monitor via Check_MK Agent')]
