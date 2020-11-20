package ru.bmstu.iu4.sem10

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit


class BlockingMap<K, V> {
    private val map = ConcurrentHashMap<K, ArrayBlockingQueue<V>>()

    private fun getQueue(key: K, replace: Boolean) = map.compute(key) { k, v ->
        if (replace || v == null) ArrayBlockingQueue(1) else v
    }

    fun put(key: K, value: V) {
        getQueue(key, true)!!.add(value)
    }

    operator fun get(key: K): V = getQueue(key, false)!!.take()

    operator fun get(key: K, timeout: Long, unit: TimeUnit) = getQueue(key, false)!!.poll(timeout, unit)
}