package com.example.profilessoundequalizerapp

import android.content.Context
import android.media.AudioManager
import android.media.ToneGenerator
import android.media.audiofx.BassBoost
import android.media.audiofx.Equalizer
import android.media.audiofx.Virtualizer
import com.example.profilessoundequalizerapp.model.entity.Profile

class SoundProfileManager(private val context: Context) {

    // Função para atualizar os valores do perfil
    fun updateProfile(profile: Profile) {


        playFeedbackSound(profile.volume *100)
    }

    private fun playFeedbackSound(volume: Float) {
        val toneGenerator = ToneGenerator(AudioManager.STREAM_MUSIC, volume.toInt()) // Volume 100
        toneGenerator.startTone(ToneGenerator.TONE_PROP_BEEP, 1000) // Tamanho do beep em milissegundos
    }
}
