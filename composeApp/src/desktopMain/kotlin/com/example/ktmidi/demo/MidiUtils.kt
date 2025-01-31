package com.example.ktmidi.demo

import dev.atsushieno.ktmidi.JvmMidiAccess
import dev.atsushieno.ktmidi.LibreMidiAccess
import dev.atsushieno.ktmidi.MidiAccess
import dev.atsushieno.ktmidi.MidiTransportProtocol
import dev.atsushieno.ktmidi.RtMidiAccess

fun getMidiAccess(): MidiAccess {
    val osName = System.getProperty("os.name").lowercase()
    println("osName: ${osName}")

    try {
        val libreMidiAccess = LibreMidiAccess.create(MidiTransportProtocol.MIDI1)
        val inputDevices = libreMidiAccess.inputs.toList()
        println("# of input devices via libremidi: ${inputDevices.size}")
        return libreMidiAccess
    } catch (e: UnsatisfiedLinkError) {
        println("Failed to use LibreMidiAccess: ${e}")
    }

    try {
        val rtMidiAccess = RtMidiAccess()
        val inputDevices = rtMidiAccess.inputs.toList()
        println("# of input devices via rtmidi: ${inputDevices.size}")
        return rtMidiAccess
    } catch (e: UnsatisfiedLinkError) {
        println("Failed to use RtMidiAccess: ${e}")
    }

    println("Using JvmMidiAccess as last resort")
    val jvmMidiAccess = JvmMidiAccess()
    val inputDevices = jvmMidiAccess.inputs.toList()
    println("# of input devices via jvm: ${inputDevices.size}")
    return jvmMidiAccess
}
